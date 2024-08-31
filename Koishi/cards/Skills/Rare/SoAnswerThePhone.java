/*    */ package Koishi.cards.Skills.Rare;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.TerrorPower;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.animations.VFXAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.vfx.CollectorCurseEffect;
/*    */ 
/*    */ public class SoAnswerThePhone extends AbstractDefaultCard {
/* 20 */   public static final String ID = KoishiMod.makeID(SoAnswerThePhone.class.getSimpleName());
/* 21 */   public static final String IMG = KoishiMod.makeCardPath("SoAnswerThePhone.png");
/*    */   
/* 23 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 24 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 25 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 26 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DEBUFF = 1;
/*    */   private static final int UPGRADE_PLUS_DEBUFF = 1;
/*    */   
/*    */   public SoAnswerThePhone() {
/* 34 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 35 */     this.magicNumber = this.baseMagicNumber = 1;
/* 36 */     this.exhaust = true;
/* 37 */     KoishiMod.setBackground((CustomCard)this, 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 42 */     if (m.hasPower(TerrorPower.POWER_ID)) {
/* 43 */       KoishiMod.runAnimation("lastWordB");
/* 44 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new SFXAction("MONSTER_COLLECTOR_DEBUFF"));
/* 45 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new VFXAction((AbstractGameEffect)new CollectorCurseEffect(m.hb.cX, m.hb.cY), 2.0F));
/* 46 */       int extraAmount = (m.getPower(TerrorPower.POWER_ID)).amount * this.magicNumber;
/* 47 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new TerrorPower((AbstractCreature)m, (AbstractCreature)p, extraAmount), extraAmount));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 54 */     return 18.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 60 */     if (!this.upgraded) {
/* 61 */       upgradeName();
/* 62 */       upgradeMagicNumber(1);
/* 63 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 64 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Rare/SoAnswerThePhone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */