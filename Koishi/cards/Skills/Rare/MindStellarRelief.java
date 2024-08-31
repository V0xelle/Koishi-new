/*    */ package Koishi.cards.Skills.Rare;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class MindStellarRelief
/*    */   extends AbstractDefaultCard {
/* 18 */   public static final String ID = KoishiMod.makeID(MindStellarRelief.class.getSimpleName());
/* 19 */   public static final String IMG = KoishiMod.makeCardPath("MindStellarRelief.png");
/*    */   
/* 21 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 22 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 23 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 24 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int DAMAGE = 15;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 3;
/*    */   private static final int BONUS_DAMAGE = 3;
/*    */   private static final int UPGRADE_PLUS_BONUS_DAMAGE = 2;
/*    */   
/*    */   public MindStellarRelief() {
/* 35 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 36 */     this.magicNumber = this.baseMagicNumber = 15;
/* 37 */     this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber = 3;
/* 38 */     AlwaysRetainField.alwaysRetain.set(this, Boolean.valueOf(true));
/* 39 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster mo) {
/* 44 */     int realMagicNumber = this.baseMagicNumber;
/* 45 */     this.baseMagicNumber += KoishiMod.debuffCount * this.defaultSecondMagicNumber;
/* 46 */     this.magicNumber = this.baseMagicNumber;
/* 47 */     super.calculateCardDamage(mo);
/* 48 */     this.baseMagicNumber = realMagicNumber;
/* 49 */     this.isMagicNumberModified = (this.magicNumber != this.baseMagicNumber);
/*    */   }
/*    */ 
/*    */   
/*    */   public void applyPowers() {
/* 54 */     int realMagicNumber = this.baseMagicNumber;
/* 55 */     this.baseMagicNumber += KoishiMod.debuffCount * this.defaultSecondMagicNumber;
/* 56 */     this.magicNumber = this.baseMagicNumber;
/* 57 */     super.applyPowers();
/* 58 */     this.baseMagicNumber = realMagicNumber;
/* 59 */     this.isMagicNumberModified = (this.magicNumber != this.baseMagicNumber);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 64 */     KoishiMod.runAnimation("mindStellarRelief");
/* 65 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.magicNumber, DamageInfo.DamageType.HP_LOSS), AbstractGameAction.AttackEffect.FIRE));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 71 */     return 20.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 77 */     if (!this.upgraded) {
/* 78 */       upgradeName();
/* 79 */       upgradeMagicNumber(3);
/* 80 */       upgradeDefaultSecondMagicNumber(2);
/* 81 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Rare/MindStellarRelief.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */