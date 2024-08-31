/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.MindControlPower;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class Possession
/*    */   extends AbstractDefaultCard
/*    */ {
/* 20 */   public static final String ID = KoishiMod.makeID(Possession.class.getSimpleName());
/* 21 */   public static final String IMG = KoishiMod.makeCardPath("Possession.png");
/*    */   
/* 23 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 24 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 25 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 26 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int UPGRADED_COST = 1;
/*    */   private static final int DEBUFF = 1;
/*    */   
/*    */   public Possession() {
/* 34 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 35 */     this.magicNumber = this.baseMagicNumber = 1;
/* 36 */     this.exhaust = true;
/* 37 */     AlwaysRetainField.alwaysRetain.set(this, Boolean.valueOf(true));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canUse(AbstractPlayer p, AbstractMonster m) {
/* 42 */     if (p.hasPower("IntangiblePlayer") || p.hasPower("Intangible")) {
/* 43 */       return super.canUse(p, m);
/*    */     }
/* 45 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 51 */     KoishiMod.runAnimation("spellC");
/* 52 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new MindControlPower((AbstractCreature)m, (AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */   
/*    */   public void triggerOnGlowCheck() {
/* 56 */     this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
/* 57 */     if (AbstractDungeon.player.hasPower("IntangiblePlayer") || AbstractDungeon.player.hasPower("Intangible")) {
/* 58 */       this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 64 */     if (!this.upgraded) {
/* 65 */       upgradeName();
/* 66 */       upgradeBaseCost(1);
/* 67 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/Possession.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */