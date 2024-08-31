/*    */ package Koishi.cards.Skills.Rare;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.ConstrictedPower;
/*    */ import com.megacrit.cardcrawl.powers.ThornsPower;
/*    */ import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class RoseHell extends AbstractDefaultCard {
/* 21 */   public static final String ID = KoishiMod.makeID(RoseHell.class.getSimpleName());
/* 22 */   public static final String IMG = KoishiMod.makeCardPath("RoseHell.png");
/*    */   
/* 24 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 25 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ALL;
/* 26 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 27 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = -1;
/*    */   
/*    */   private static final int EFFECT = 2;
/*    */   
/*    */   public RoseHell() {
/* 34 */     super(ID, IMG, -1, TYPE, COLOR, RARITY, TARGET);
/* 35 */     this.magicNumber = this.baseMagicNumber = 2;
/* 36 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 41 */     KoishiMod.runAnimation("spellC");
/* 42 */     int effect = EnergyPanel.totalCount;
/* 43 */     if (this.energyOnUse > 0) {
/* 44 */       effect = this.energyOnUse;
/*    */     }
/* 46 */     if (p.hasRelic("Chemical X")) {
/* 47 */       effect += 2;
/* 48 */       p.getRelic("Chemical X").flash();
/*    */     } 
/* 50 */     if (this.upgraded) {
/* 51 */       effect++;
/*    */     }
/* 53 */     if (effect > 0) {
/* 54 */       for (int i = 0; i < effect; i++) {
/* 55 */         AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new ThornsPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/* 56 */         Iterator<AbstractMonster> iterator = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
/* 57 */         while (iterator.hasNext()) {
/* 58 */           AbstractMonster mo = iterator.next();
/* 59 */           AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new ConstrictedPower((AbstractCreature)mo, (AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */         } 
/*    */       } 
/* 62 */       if (!this.freeToPlayOnce) {
/* 63 */         p.energy.use(EnergyPanel.totalCount);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 70 */     if (!this.upgraded) {
/* 71 */       upgradeName();
/* 72 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 73 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Rare/RoseHell.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */